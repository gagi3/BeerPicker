import { Component, OnInit, ViewChild } from '@angular/core';
import { BeerService } from 'src/app/service/beer.service';
import { Beer } from 'src/app/model/beer';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { BeerEditDialogComponent } from '../beer-edit-dialog/beer-edit-dialog.component';
import { BeerAddDialogComponent } from '../beer-add-dialog/beer-add-dialog.component';

@Component({
  selector: 'app-beer-table',
  templateUrl: './beer-table.component.html',
  styleUrls: ['./beer-table.component.css']
})
export class BeerTableComponent implements OnInit {
  beers: Beer[] = [];
  dataSource: MatTableDataSource<Beer>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  displayedColumns: string[] = [
    'name',
    'strength',
    'type',
    'style',
    'flavours',
    'edit',
    'delete'
  ];

  constructor(private service: BeerService, private dialog: MatDialog) { }

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.beers = data;
      this.dataSource = new MatTableDataSource(this.beers);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  add() {
    let beer = new Beer();
    const dialogRef = this.dialog.open(BeerAddDialogComponent, {
      data: {
        beer
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.service.create(result).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }
  edit(beer: Beer) {
    const dialogRef = this.dialog.open(BeerEditDialogComponent, {
      data: {
        beer
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.service.update(result).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }
  delete(beer: Beer) {
    this.service.delete(beer.id).subscribe(data => {
      window.alert(data);
    });
  }

}

import { Component, OnInit, ViewChild } from '@angular/core';
import { Food } from 'src/app/model/food';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { FoodService } from 'src/app/service/food.service';
import { MatDialog } from '@angular/material/dialog';
import { FoodAddDialogComponent } from '../food-add-dialog/food-add-dialog.component';
import { FoodEditDialogComponent } from '../food-edit-dialog/food-edit-dialog.component';
import { DroolsService } from 'src/app/service/drools.service';
import { BeerTableDialogComponent } from '../../beer/beer-table-dialog/beer-table-dialog.component';

@Component({
  selector: 'app-food-table',
  templateUrl: './food-table.component.html',
  styleUrls: ['./food-table.component.css']
})
export class FoodTableComponent implements OnInit {
  foods: Food[] = [];
  dataSource: MatTableDataSource<Food>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  displayedColumns: string[] = [
    'name',
    'type',
    'edit',
    'delete',
    'recommend'
  ];

  constructor(private service: FoodService, private dialog: MatDialog, private drools: DroolsService) { }

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.foods = data;
      this.dataSource = new MatTableDataSource(this.foods);
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
    let food = new Food();
    const dialogRef = this.dialog.open(FoodAddDialogComponent, {
      data: {
        food
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
  edit(food: Food) {
    const dialogRef = this.dialog.open(FoodEditDialogComponent, {
      data: {
        food
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.service.update(result).subscribe(data => {
          this.ngOnInit();
        });
      } else {
        result = food;
      }
    });
  }
  delete(food: Food) {
    this.service.delete(food.id).subscribe(data => {
      window.alert(data);
    });
  }
  recommend(food: Food) {
    this.drools.recommendByFood(food).subscribe(data => {
      const beer = data;
      this.dialog.open(BeerTableDialogComponent, {
        data: {
          beer
        }
      });
    });
  }
}

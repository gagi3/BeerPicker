import { Component, OnInit, ViewChild } from '@angular/core';
import { Dish } from 'src/app/model/dish';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { DishService } from 'src/app/service/dish.service';
import { MatDialog } from '@angular/material/dialog';
import { DishAddDialogComponent } from '../dish-add-dialog/dish-add-dialog.component';
import { DishEditDialogComponent } from '../dish-edit-dialog/dish-edit-dialog.component';
import { FoodTableDialogComponent } from '../../food/food-table-dialog/food-table-dialog.component';
import { DroolsService } from 'src/app/service/drools.service';
import { BeerTableDialogComponent } from '../../beer/beer-table-dialog/beer-table-dialog.component';

@Component({
  selector: 'app-dish-table',
  templateUrl: './dish-table.component.html',
  styleUrls: ['./dish-table.component.css']
})
export class DishTableComponent implements OnInit {
  dishes: Dish[] = [];
  dataSource: MatTableDataSource<Dish>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  displayedColumns: string[] = [
    'name',
    'type',
    // 'descriptors',
    'preparation',
    'saltinessIndex',
    'spicinessIndex',
    'sweetnessIndex',
    'sournessIndex',
    'bitternessIndex',
    'ingredients',
    'edit',
    'delete',
    'recommend'
  ];

  constructor(private service: DishService, private dialog: MatDialog, private drools: DroolsService) { }

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.dishes = data;
      this.dataSource = new MatTableDataSource(this.dishes);
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
  ingredients(dish: Dish) {
    const food = dish.ingredients;
    this.dialog.open(FoodTableDialogComponent, {
      data: {
        food
      }
    });
  }
  add() {
    let dish = new Dish();
    const dialogRef = this.dialog.open(DishAddDialogComponent, {
      data: {
        dish
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        console.log(result);
        this.service.create(result).subscribe(data => {
          console.log(data);
          this.ngOnInit();
        });
      }
    });
  }
  edit(dish: Dish) {
    const dialogRef = this.dialog.open(DishEditDialogComponent, {
      data: {
        dish
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
  delete(dish: Dish) {
    this.service.delete(dish.id).subscribe(data => {
      window.alert(data);
    });
  }
  recommend(dish: Dish) {
    this.drools.recommendByDish(dish).subscribe(data => {
      const beer = data;
      this.dialog.open(BeerTableDialogComponent, {
        data: {
          beer
        }
      });
    });
  }
}

import { Component, OnInit, ViewChild } from '@angular/core';
import { Meal } from 'src/app/model/meal';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MealService } from 'src/app/service/meal.service';
import { MatDialog } from '@angular/material/dialog';
import { MealAddDialogComponent } from '../meal-add-dialog/meal-add-dialog.component';
import { MealEditDialogComponent } from '../meal-edit-dialog/meal-edit-dialog.component';
import { DishTableDialogComponent } from '../../dish/dish-table-dialog/dish-table-dialog.component';
import { DroolsService } from 'src/app/service/drools.service';
import { BeerTableDialogComponent } from '../../beer/beer-table-dialog/beer-table-dialog.component';

@Component({
  selector: 'app-meal-table',
  templateUrl: './meal-table.component.html',
  styleUrls: ['./meal-table.component.css']
})
export class MealTableComponent implements OnInit {
  meals: Meal[] = [];
  dataSource: MatTableDataSource<Meal>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  displayedColumns: string[] = [
    'name',
    'type',
    'dishes',
    'edit',
    'delete',
    'recommend'
  ];

  constructor(private service: MealService, private dialog: MatDialog, private drools: DroolsService) { }

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.meals = data;
      this.dataSource = new MatTableDataSource(this.meals);
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
  dishes(meal: Meal) {
    const dishes = meal.dishes;
    this.dialog.open(DishTableDialogComponent, {
      data: {
        dishes
      }
    });
  }
  add() {
    let meal = new Meal();
    const dialogRef = this.dialog.open(MealAddDialogComponent, {
      data: {
        meal
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
  edit(meal: Meal) {
    const dialogRef = this.dialog.open(MealEditDialogComponent, {
      data: {
        meal
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
  delete(meal: Meal) {
    this.service.delete(meal.id).subscribe(data => {
      window.alert(data);
    });
  }
  recommend(meal: Meal) {
    this.drools.recommendByMeal(meal).subscribe(data => {
      const beer = data;
      this.dialog.open(BeerTableDialogComponent, {
        data: {
          beer
        }
      });
    });
  }
}

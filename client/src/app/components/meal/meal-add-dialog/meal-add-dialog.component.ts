import { Component, OnInit, Inject } from '@angular/core';
import { Dish } from 'src/app/model/dish';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DishAddDialogComponent } from '../../dish/dish-add-dialog/dish-add-dialog.component';
import { DishService } from 'src/app/service/dish.service';

@Component({
  selector: 'app-meal-add-dialog',
  templateUrl: './meal-add-dialog.component.html',
  styleUrls: ['./meal-add-dialog.component.css']
})
export class MealAddDialogComponent implements OnInit {
  dishes: Dish[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<MealAddDialogComponent>, private dishService: DishService) { }
  ngOnInit(): void {
    this.dishService.getAll().subscribe(data => {
      this.dishes = data;
    });
  }

  close() {
    this.dialogRef.close();
  }

}

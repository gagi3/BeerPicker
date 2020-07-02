import { Component, OnInit, Inject } from '@angular/core';
import { Dish } from 'src/app/model/dish';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DishService } from 'src/app/service/dish.service';

@Component({
  selector: 'app-meal-edit-dialog',
  templateUrl: './meal-edit-dialog.component.html',
  styleUrls: ['./meal-edit-dialog.component.css']
})
export class MealEditDialogComponent implements OnInit {
  dishes: Dish[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<MealEditDialogComponent>, private dishService: DishService) { }
  ngOnInit(): void {
    this.dishService.getAll().subscribe(data => {
      this.dishes = data;
    });
  }

  close() {
    this.dialogRef.close();
  }
}

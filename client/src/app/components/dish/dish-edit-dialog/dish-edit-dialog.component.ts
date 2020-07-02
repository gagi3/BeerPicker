import { Component, OnInit, Inject } from '@angular/core';
import { Food } from 'src/app/model/food';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FoodService } from 'src/app/service/food.service';

@Component({
  selector: 'app-dish-edit-dialog',
  templateUrl: './dish-edit-dialog.component.html',
  styleUrls: ['./dish-edit-dialog.component.css']
})
export class DishEditDialogComponent implements OnInit {

  food: Food[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<DishEditDialogComponent>, private foodService: FoodService) { }
  ngOnInit(): void {
    this.foodService.getAll().subscribe(data => {
      this.food = data;
    });
  }

  close() {
    this.dialogRef.close();
  }

}

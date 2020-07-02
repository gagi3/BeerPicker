import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FoodService } from 'src/app/service/food.service';
import { Food } from 'src/app/model/food';

@Component({
  selector: 'app-dish-add-dialog',
  templateUrl: './dish-add-dialog.component.html',
  styleUrls: ['./dish-add-dialog.component.css']
})
export class DishAddDialogComponent implements OnInit {

  food: Food[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<DishAddDialogComponent>, private foodService: FoodService) { }
  ngOnInit(): void {
    this.foodService.getAll().subscribe(data => {
      this.food = data;
    });
  }

  close() {
    this.dialogRef.close();
  }

}

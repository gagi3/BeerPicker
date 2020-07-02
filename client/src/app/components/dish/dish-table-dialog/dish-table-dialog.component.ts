import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material/dialog';
import { Dish } from 'src/app/model/dish';
import { FoodTableDialogComponent } from '../../food/food-table-dialog/food-table-dialog.component';

@Component({
  selector: 'app-dish-table-dialog',
  templateUrl: './dish-table-dialog.component.html',
  styleUrls: ['./dish-table-dialog.component.css']
})
export class DishTableDialogComponent {
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
    'ingredients'
  ];
  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialog: MatDialog, private dialogRef: MatDialogRef<DishTableDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

  ingredients(dish: Dish) {
    const food = dish.ingredients;
    this.dialog.open(FoodTableDialogComponent, {
      data: {
        food
      }
    });
  }

}

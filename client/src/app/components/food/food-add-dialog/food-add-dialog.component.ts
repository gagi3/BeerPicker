import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-food-add-dialog',
  templateUrl: './food-add-dialog.component.html',
  styleUrls: ['./food-add-dialog.component.css']
})
export class FoodAddDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<FoodAddDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

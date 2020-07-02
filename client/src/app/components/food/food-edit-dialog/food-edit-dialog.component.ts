import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-food-edit-dialog',
  templateUrl: './food-edit-dialog.component.html',
  styleUrls: ['./food-edit-dialog.component.css']
})
export class FoodEditDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<FoodEditDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

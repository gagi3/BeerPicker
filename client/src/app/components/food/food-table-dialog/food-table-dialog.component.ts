import { Component, OnInit, Inject, AfterViewInit, AfterContentInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-food-table-dialog',
  templateUrl: './food-table-dialog.component.html',
  styleUrls: ['./food-table-dialog.component.css']
})
export class FoodTableDialogComponent {


  displayedColumns: string[] = [
    'name',
    'type'
  ];
  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<FoodTableDialogComponent>) {}


  close() {
    this.dialogRef.close();
  }

}

import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DishTableDialogComponent } from '../../dish/dish-table-dialog/dish-table-dialog.component';

@Component({
  selector: 'app-beer-table-dialog',
  templateUrl: './beer-table-dialog.component.html',
  styleUrls: ['./beer-table-dialog.component.css']
})
export class BeerTableDialogComponent {

  displayedColumns: string[] = [
    'name',
    'strength',
    'type',
    'style',
    'flavours'
  ];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<BeerTableDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

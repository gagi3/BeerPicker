import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-beer-add-dialog',
  templateUrl: './beer-add-dialog.component.html',
  styleUrls: ['./beer-add-dialog.component.css']
})
export class BeerAddDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<BeerAddDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

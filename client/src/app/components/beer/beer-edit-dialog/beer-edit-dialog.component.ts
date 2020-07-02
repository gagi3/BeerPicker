import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-beer-edit-dialog',
  templateUrl: './beer-edit-dialog.component.html',
  styleUrls: ['./beer-edit-dialog.component.css']
})
export class BeerEditDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<BeerEditDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

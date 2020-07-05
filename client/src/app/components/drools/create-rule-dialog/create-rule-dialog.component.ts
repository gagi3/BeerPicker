import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-rule-dialog',
  templateUrl: './create-rule-dialog.component.html',
  styleUrls: ['./create-rule-dialog.component.css']
})
export class CreateRuleDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<CreateRuleDialogComponent>) { }

  close() {
    this.dialogRef.close();
  }

}

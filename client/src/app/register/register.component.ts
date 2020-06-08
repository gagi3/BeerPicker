import { Component, OnInit } from '@angular/core';
import { SignUpRequest } from '../auth/sign-up-request';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  request: SignUpRequest = new SignUpRequest();
  private signedUp = false;
  private signUpFailed = false;

  constructor(private token: TokenStorageService, private auth: AuthService, private dialogRef: MatDialogRef<RegisterComponent>) { }

  ngOnInit() {
    if (this.token.getToken !== null) {
      this.dialogRef.close();
    }
  }
  register() {
    this.auth.register(this.request).subscribe(data => {
      this.signUpFailed = false;
      this.signedUp = true;
      this.dialogRef.close();
    }, error => {
      this.signUpFailed = true;
      location.reload();
    })
  }
  cancel() {
    this.dialogRef.close();
  }

}

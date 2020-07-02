import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './auth/token-storage.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SignInRequest } from './auth/sign-in-request';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Beer picker';
  links: any[];
  activeLinkIndex = -1;
  user = false;
  constructor(private router: Router, private token: TokenStorageService, private dialog: MatDialog) {
    if (this.token.getUsername() !== null) {
      this.user = true;
      this.token.getAuthorities().forEach(auth => {
        if (auth === 'ROLE_ADMIN') {
          this.links = [
            {
              label: 'Foods',
              link: '/food',
              index: 0
            },
            {
              label: 'Dishes',
              link: '/dish',
              index: 1
            },
            {
              label: 'Meals',
              link: '/meal',
              index: 2
            },
            {
              label: 'Beers',
              link: '/beer',
              index: 3
            },
            {
              label: 'Rules',
              link: '',
              index: 4
            }
          ]
        } else if (auth === 'ROLE_USER') {
          this.links = [
            {
              label: 'Beer recommendation',
              link: '',
              index: 0
            },
            {
              label: 'Food recommendation',
              link: '',
              index: 1
            }
          ]
        }
      });
    } else {
      this.links = [
        {
          label: 'Browse beers',
          link: '/beer',
          index: 0
        }
      ]
    }

  }
  login() {
    const dialogRef = this.dialog.open(LoginComponent, {
      data: new SignInRequest()
    });
    dialogRef.afterClosed().subscribe(result => {
      location.reload();
    });
  }
  logout() {
    const dialogRef = this.token.signOut();
    location.reload();
  }
  register() {
    const dialogRef = this.dialog.open(RegisterComponent);
    dialogRef.afterClosed().subscribe(result => {
      location.reload();
    });
  }
  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.links.indexOf(this.links.find(tab => tab.link === '.' + this.router.url));
    });
  }
}

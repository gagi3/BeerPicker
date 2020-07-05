import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http'
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { MatSortModule } from '@angular/material/sort';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatExpansionModule } from '@angular/material/expansion';
import { BeerAddDialogComponent } from './components/beer/beer-add-dialog/beer-add-dialog.component';
import { BeerEditDialogComponent } from './components/beer/beer-edit-dialog/beer-edit-dialog.component';
import { BeerTableComponent } from './components/beer/beer-table/beer-table.component';
import { DishAddDialogComponent } from './components/dish/dish-add-dialog/dish-add-dialog.component';
import { DishEditDialogComponent } from './components/dish/dish-edit-dialog/dish-edit-dialog.component';
import { DishTableComponent } from './components/dish/dish-table/dish-table.component';
import { FoodAddDialogComponent } from './components/food/food-add-dialog/food-add-dialog.component';
import { FoodEditDialogComponent } from './components/food/food-edit-dialog/food-edit-dialog.component';
import { CreateRuleDialogComponent } from './components/drools/create-rule-dialog/create-rule-dialog.component';
import { FoodTableComponent } from './components/food/food-table/food-table.component';
import { MealAddDialogComponent } from './components/meal/meal-add-dialog/meal-add-dialog.component';
import { MealEditDialogComponent } from './components/meal/meal-edit-dialog/meal-edit-dialog.component';
import { MealTableComponent } from './components/meal/meal-table/meal-table.component';
import { BeerTableDialogComponent } from './components/beer/beer-table-dialog/beer-table-dialog.component';
import { DishTableDialogComponent } from './components/dish/dish-table-dialog/dish-table-dialog.component';
import { FoodTableDialogComponent } from './components/food/food-table-dialog/food-table-dialog.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';

@NgModule({
   declarations: [
      AppComponent,

      LoginComponent,
      RegisterComponent,

      BeerAddDialogComponent,
      BeerEditDialogComponent,
      BeerTableComponent,
      BeerTableDialogComponent,

      DishAddDialogComponent,
      DishEditDialogComponent,
      DishTableComponent,
      DishTableDialogComponent,

      FoodAddDialogComponent,
      FoodEditDialogComponent,
      FoodTableComponent,
      FoodTableDialogComponent,

      MealAddDialogComponent,
      MealEditDialogComponent,
      MealTableComponent,

      CreateRuleDialogComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      HttpClientModule,
      MatFormFieldModule,
      MatTableModule,
      MatPaginatorModule,
      MatSortModule,
      MatToolbarModule,
      MatTabsModule,
      MatIconModule,
      MatButtonModule,
      MatDialogModule,
      MatSelectModule,
      MatRadioModule,
      MatInputModule,
      FormsModule,
      MatTooltipModule,
      MatExpansionModule,
      MatCheckboxModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }

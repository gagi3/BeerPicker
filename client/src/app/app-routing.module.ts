import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BeerTableComponent } from './components/beer/beer-table/beer-table.component';
import { MealTableComponent } from './components/meal/meal-table/meal-table.component';
import { DishTableComponent } from './components/dish/dish-table/dish-table.component';
import { FoodTableComponent } from './components/food/food-table/food-table.component';


const routes: Routes = [
  {
    path: 'beer',
    component: BeerTableComponent
  },
  {
    path: 'food',
    component: FoodTableComponent
  },
  {
    path: 'dish',
    component: DishTableComponent
  },
  {
    path: 'meal',
    component: MealTableComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

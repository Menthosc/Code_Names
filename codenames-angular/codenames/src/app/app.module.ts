import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Component, HostListener } from '@angular/core';
import { AppComponent } from './app.component';
import { JeuComponent } from './jeu/jeu.component';
import {HttpClientModule} from '@angular/common/http';
import { CaseComponent } from './case/case.component';





//Configuration des routes
const routes: Routes = [
{ path: 'jeu', component: JeuComponent },
{ path: '', redirectTo: 'jeu', pathMatch: 'full' },
];









@NgModule({
  declarations: [
    AppComponent,
    CaseComponent,
    JeuComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [AppConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }

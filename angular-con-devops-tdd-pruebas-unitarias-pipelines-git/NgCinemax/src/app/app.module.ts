import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NavbarSocialComponent } from './landing-page/navbar-social/navbar-social.component';
import { NavbarMenuComponent } from './landing-page/navbar-menu/navbar-menu.component';
import { MoviesFilterComponent } from './landing-page/movies-filter/movies-filter.component';
import { SlidesComponent } from './landing-page/slides/slides.component';
import { WeeklyBilboardsComponent } from './landing-page/weekly-bilboards/weekly-bilboards.component';
import { PremieresComponent } from './landing-page/premieres/premieres.component';
import { CarouselComponent } from './landing-page/carousel/carousel.component';
import { FooterComponent } from './landing-page/footer/footer.component';
import { LandingPageService } from './services/landing-page.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    NavbarSocialComponent,
    NavbarMenuComponent,
    MoviesFilterComponent,
    SlidesComponent,
    WeeklyBilboardsComponent,
    PremieresComponent,
    CarouselComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LandingPageService],
  bootstrap: [AppComponent]
})
export class AppModule { }

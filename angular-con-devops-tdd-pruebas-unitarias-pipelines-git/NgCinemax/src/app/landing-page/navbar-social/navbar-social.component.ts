import { Component, OnInit } from '@angular/core';
import { LandingPageService } from 'src/app/services/landing-page.service';
import { SocialNetwork } from './social-network';

@Component({
  selector: 'app-navbar-social',
  templateUrl: './navbar-social.component.html',
  styleUrls: ['./navbar-social.component.css']
})
export class NavbarSocialComponent implements OnInit {
  socialNetworks : SocialNetwork[] = []
  constructor(public _landingService:LandingPageService) { }

  ngOnInit() {
    this.getSocialNetworks()
  }

  getSocialNetworks(){
    this._landingService.getSocialNetworks().subscribe((redes)=>{
      this.socialNetworks = redes
      console.log(this.socialNetworks)
    })
  }

}

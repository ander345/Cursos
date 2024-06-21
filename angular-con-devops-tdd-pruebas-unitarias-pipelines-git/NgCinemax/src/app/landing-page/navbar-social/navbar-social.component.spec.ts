import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSocialComponent } from './navbar-social.component';
import { LandingPageService } from 'src/app/services/landing-page.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { SocialNetwork } from './social-network';
import { of } from 'rxjs'
describe('NavbarSocialComponent', () => {
  let component: NavbarSocialComponent;
  let fixture: ComponentFixture<NavbarSocialComponent>;
  let service : LandingPageService

  let mockResponse : SocialNetwork[] = [
    {
      "clase": "fab fa-facebook-f",
      "estado": true,
      "nombre": "Facebook",
      "url": "fb.com/jhonantanplata"
      },
      {
      "clase": "fab fa-twitter",
      "estado": true,
      "nombre": "Twitter",
      "url": "twitter.com/jhonantanplata"
      },
      {
      "clase": "fab fa-youtube",
      "estado": true,
      "nombre": "Youtube",
      "url": "https://www.youtube.com/channel/UCjWtzTnT35nxnJmDaH2r3OA"
      },
      {
      "clase": "fab fa-instagram",
      "estado": true,
      "nombre": "Instagram",
      "url": "www.instagram.com/"
      }
  ]

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarSocialComponent ],
      providers: [LandingPageService],
      imports : [HttpClientTestingModule],
      schemas : [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarSocialComponent);
    component = fixture.componentInstance;
    service = component._landingService
    fixture.detectChanges();
  });

  it('Debe crear el componente', () => {
    expect(component).toBeTruthy();
  });

  it('Debe inyectar LandingPageService', ()=>{
    expect(service).toBeTruthy()
  })

  it('Debe llenar la variable socialNetworks al llamar getSocialNetworks() de _landingService', ()=>{
    spyOn(service, 'getSocialNetworks').and.returnValue(of(mockResponse))

    component.ngOnInit()
    expect(component.socialNetworks).toEqual(mockResponse)
  })

  it('Debe llamar getSocialNetworks() en el ngOnInit()', ()=>{
    spyOn(component, 'getSocialNetworks').and.callThrough()
    spyOn(service, 'getSocialNetworks').and.returnValue(of(mockResponse))

    component.ngOnInit()
    expect(component.getSocialNetworks).toHaveBeenCalled()
  })
});

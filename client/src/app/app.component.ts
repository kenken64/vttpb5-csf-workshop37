import { Component, OnInit } from '@angular/core';
import { CitiesService } from './services/cities.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'client';

  constructor(private citiesService: CitiesService){
    console.log('AppComponent initialized');
    this.citiesService.initCitiesToIndexDb();
  }

  ngOnInit(){
    
  }
}

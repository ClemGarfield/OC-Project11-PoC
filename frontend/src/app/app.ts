import { Component } from '@angular/core';
import { HospitalSearchComponent } from './hospital-search/hospital-search';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HospitalSearchComponent
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}

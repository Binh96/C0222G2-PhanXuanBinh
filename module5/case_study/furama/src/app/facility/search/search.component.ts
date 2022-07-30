import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Facility } from '../facility';
import { FacilityService } from '../facility-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  facilities: Facility[] = [];
  search: string;

  constructor(private facilityService: FacilityService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p : ParamMap)=>{
      this.search = p.get('search');
      console.log(this.search);
      this.getFacility(this.search);
   });
  }

  getFacility(search: string){
    this.facilityService.findByName(search).subscribe(facility => {
      this.facilities = facility;
    });
  }

}

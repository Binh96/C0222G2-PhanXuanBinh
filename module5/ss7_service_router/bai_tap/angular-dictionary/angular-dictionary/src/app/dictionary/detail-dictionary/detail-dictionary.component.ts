import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Dictionary } from 'src/app/dictionary';
import { DictionaryService } from 'src/app/dictionary-service.service';

@Component({
  selector: 'app-detail-dictionary',
  templateUrl: './detail-dictionary.component.html',
  styleUrls: ['./detail-dictionary.component.css']
})
export class DetailDictionaryComponent implements OnInit {

  detail: Dictionary;

  constructor(private dictionaryService: DictionaryService, private dictionaryRoute: ActivatedRoute) { 
    this.getDetail();
  }

  ngOnInit(): void {
  }

  getDetail(){
    this.dictionaryRoute.paramMap.subscribe((p: ParamMap) => {
      this.detail = this.dictionaryService.findByWord(p.get('word'));
    });
  }

}

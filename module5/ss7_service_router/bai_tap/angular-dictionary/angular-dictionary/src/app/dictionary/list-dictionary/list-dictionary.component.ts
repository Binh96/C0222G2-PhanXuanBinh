import { Component, OnInit } from '@angular/core';
import { Dictionary } from 'src/app/dictionary';
import { DictionaryService } from 'src/app/dictionary-service.service';

@Component({
  selector: 'app-list-dictionary',
  templateUrl: './list-dictionary.component.html',
  styleUrls: ['./list-dictionary.component.css']
})
export class ListDictionaryComponent implements OnInit {

  dictionaries: Dictionary[] = [];

  constructor(private dictionaryService: DictionaryService) { 
    this.dictionaries = this.dictionaryService.getAll();
  }

  ngOnInit(): void {

  }

}

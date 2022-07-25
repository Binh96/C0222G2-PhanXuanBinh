import { Component, OnInit } from '@angular/core';
import { FileService } from './file-service.service';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {
  shortLink: string = '';
  loading: boolean = false;
  file: File = null;

  constructor(private fileUploadService: FileService) { 

  }

  ngOnInit(): void {
  }

  onChange(event){
    this.file = event.target.file[0];
  }

  onUpload(){
    this.loading = !this.loading;
    this.fileUploadService.upload(this.file).subscribe((event: any) =>
    { 
      if(typeof (event) === 'object'){
        this.shortLink = event.link;
        this.loading = false;
      }
    });
  }

}

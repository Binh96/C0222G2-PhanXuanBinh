import { Component, OnInit, Input, Output, EventEmitter, SimpleChanges, OnChanges, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-angular-countdow-timer',
  templateUrl: './angular-countdow-timer.component.html',
  styleUrls: ['./angular-countdow-timer.component.css']
})
export class AngularCountdowTimerComponent implements OnInit, OnChanges, OnDestroy {
  message = '';
  @Input() seconds = 11;
  @Output() finish = new EventEmitter<boolean>();
  remainingTime: number;
  private interValid = 0;


  constructor() { }

  ngOnChanges(changes: SimpleChanges){
    if('seconds' in changes){
      let v = changes.seconds.currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      this.seconds = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }

  ngOnInit(): void {
    this.reset();
  }

  clearTimer(){
    clearInterval(this.interValid);
  }

  ngOnDestroy(): void {
      this.clearTimer();
  }
  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
  }

  private countDown() {
    this.clearTimer();
    this.interValid = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.message = 'Blast off!';
        this.clearTimer();
        this.finish.emit(true);
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }


}

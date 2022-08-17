import { Component, OnInit, OnDestroy } from "@angular/core";
import Chart from "chart.js";

@Component({
  selector: "app-landingpage",
  templateUrl: "landingpage.component.html"
})
export class LandingpageComponent implements OnInit, OnDestroy {
  isCollapsed = true;
  constructor() {}

  ngOnInit() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.add("landing-page");
  }
  ngOnDestroy() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.remove("landing-page");
  }
}

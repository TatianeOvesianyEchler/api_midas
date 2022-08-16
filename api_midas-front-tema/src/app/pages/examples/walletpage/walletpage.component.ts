import { Component, OnInit, OnDestroy } from "@angular/core";

@Component({
  selector: "app-walletpage",
  templateUrl: "walletpage.component.html"
})
export class WalletpageComponent implements OnInit, OnDestroy {
  isCollapsed = true;
  constructor() {}

  ngOnInit() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.add("walletpage-page");
  }
  ngOnDestroy() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.remove("walletpage-page");
  }
}

import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {Receipt} from "../model/receipt.model";
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-list-receipt',
  templateUrl: './list-receipt.component.html',
  styleUrls: ['./list-receipt.component.css']
})
export class ListReceiptComponent implements OnInit {

  receipts: Receipt[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    if(!window.localStorage.getItem('token')) {
      this.router.navigate(['login']);
      return;
    }
    this.apiService.getReceipt()
      .subscribe( data => {
          this.receipts = data.result;
      });
  }

  deleteReceipt(receipt: Receipt): void {
    this.apiService.deleteReceipt(receipt.id)
      .subscribe( data => {
        this.receipts = this.receipts.filter(u => u !== receipt);
      })
  };

  editReceipt(receipt: Receipt): void {
    window.localStorage.removeItem("editReceiptId");
    window.localStorage.setItem("editReceiptId", receipt.id.toString());
    this.router.navigate(['edit-receipt']);
  };

  addReceipt(): void {
    this.router.navigate(['add-receipt']);
  };
}

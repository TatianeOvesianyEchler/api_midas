import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginpageComponent } from "./examples/loginpage/loginpage.component";
import { PagesComponent } from './pages.component';

const routes: Routes = [
    {
        path: '',
        component: PagesComponent, 
        children: [
            {
                path: '',
                component: LoginpageComponent,
            },
        ],
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PagesRoutingModule {}
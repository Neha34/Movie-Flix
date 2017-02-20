import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { RouterModule} from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {HomeComponent} from './home/home.component';
import {SignupComponent} from './sign-up/sign-up.component';
import {LoginComponent} from './login/login.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {VideoListComponent} from './video-list/video-list.component';
import {AddTitleComponent} from './movie/add-title.component';
import {RemoveTitleComponent} from './movie/remove-title.component';
import {VideoDetailComponent} from './video-detail/video-detail.component';
import {UserService} from './Service/user.service';
import {VideoService} from "./Service/video.service";
import {EditTitleComponent} from "./movie/edit-title.component";

const appRoutes = [
    {path: 'home', component: HomeComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'login', component: LoginComponent},
    {path: 'add_title', component: AddTitleComponent},
    {path: 'edit_title', component: RemoveTitleComponent},
    {path: 'edit_title/:videoId', component: EditTitleComponent},
    {path: 'video_list', component: VideoListComponent},
    {path: 'video_list/:movieId', component: VideoDetailComponent},
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: '**', component: NotFoundComponent}
];

@NgModule({
    imports: [BrowserModule, FormsModule,HttpModule,RouterModule.forRoot(appRoutes)],
    declarations: [AppComponent, NotFoundComponent,HomeComponent, SignupComponent, LoginComponent,
        AddTitleComponent, RemoveTitleComponent, VideoListComponent, VideoDetailComponent, EditTitleComponent],
    providers: [UserService,VideoService],
    bootstrap: [AppComponent]
})
export class AppModule {
}

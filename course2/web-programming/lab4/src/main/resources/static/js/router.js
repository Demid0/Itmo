import { createRouter, createWebHashHistory } from "vue-router";
import Main from "./pages/Main.vue";
import Login from "./pages/authentication/Login.vue";
import Register from "./pages/authentication/Register.vue";
import Logout from "./pages/authentication/Logout.vue";
import Error from "./components/errors/Error.vue";
import {store} from "./store";
import User from "./pages/User.vue";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: "/main", name: 'Main', component: Main, meta: { forAuth: true } },
        { path: "/register", name: 'Register', component: Register, meta: { forAuth: false } },
        { path: "/login", name: 'Login1', component: Login, meta: { forAuth: false } },
        { path: "/", name: 'Login2', component: Login, meta: { forAuth: false } },
        { path: "/logout", name: 'Logout', component: Logout, meta: { forAuth: true } },
        { path: '/user', name: 'User', component: User, meta: { forAuth: true } },
        { path: '/:pathMatch(.*)*', name: '404', component: Error }
    ],
});

router.beforeEach((to, from, next) => {
    if (to.meta.forAuth === true && !store.getters.isAuthenticated) next({ name: 'Login1' });
    else {
        if (to.meta.forAuth === false && store.getters.isAuthenticated) next({ name: '404' });
        else next();
    }
});
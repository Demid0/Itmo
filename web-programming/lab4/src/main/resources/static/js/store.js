import Vuex from 'vuex';

const state = {
    token: localStorage.getItem('token') || '',
    username: localStorage.getItem('username') || ''
};

const getters = {
    isAuthenticated: state => {
        return state.token !== '' && state.token !== null && state.token !== '';
    },
    getUsername: state => {
        return state.username;
    },
    getToken: state => {
        return state.token;
    }
};

const mutations = {
    auth_login: (state, user) => {
        state.token = user.token;
        state.username = user.username;
        localStorage.setItem('token', user.token);
        localStorage.setItem('username', user.username);
    },
    auth_logout: () => {
        state.token = '';
        state.username = '';
        localStorage.removeItem('token');
        localStorage.removeItem('username');
    }
};

const actions = {
    login: (context, user) => {
        context.commit('auth_login', user);
    },
    logout: (context) => {
        context.commit('auth_logout');
    }
};

export const store = new Vuex.Store({
    actions,
    getters,
    state,
    mutations
});
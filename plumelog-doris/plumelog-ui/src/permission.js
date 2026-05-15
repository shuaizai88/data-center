import router from "./router"

// 全局前置守卫
router.beforeEach((to, from, next) => {
    if (to.query.token) {
        sessionStorage.setItem('Authorization', to.query.token);
    }
    next()
})
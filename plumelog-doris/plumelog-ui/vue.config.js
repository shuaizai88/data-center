module.exports= {
    devServer: {
        port: 3003,
        open: true,
        overlay: {
            warnings: false,
            errors: false
        },
        proxy: {
            '/api': {
                // target: 'http://36.133.102.59:8082/',
                target: 'http://127.0.0.1:8891/',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/'
                }
            },
            '/wsapi': {
                // target: 'http://36.133.102.59:8082/',
                target: 'http://127.0.0.1:8891/',
                changeOrigin: true,
                pathRewrite: {
                    '^/wsapi': '/'
                }
            }
        },
        disableHostCheck: true
    }
}
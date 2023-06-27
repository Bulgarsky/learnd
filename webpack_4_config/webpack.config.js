//npm i path
let path = require('path');
let ExtractTextPlugin = require("extract-text-webpack-plugin")

let conf = {
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, './dist'),
        filename: 'main.js',
        publicPath:'dist/'
    },
    devServer: {
        //overlay: true
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                //exclude: '/node_modules'
                //exclude: path.resolve(__dirname, 'node_modules')
            },
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader"
                })
                // use: [
                // 'style-loader',
                // 'css-loader'
                // ]
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin("styles.css")
    ]
    //devtool: 'eval-sourcemap'
};

module.exports = (env, options) => {
    let production = options.mode === 'production';
    conf.devtool = production
        //чтобы скрыть код
        ? false
        //? 'source-map'
        : 'eval-sourcemap';

    return conf;
}
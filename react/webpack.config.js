let path = require("path");
let MiniCssExtractPlugin = require("mini-css-extract-plugin");


let conf = {
	entry: './src/index.js',
	output: {
		path: path.resolve(__dirname, './dist'),
		filename: 'main.js',
		publicPath: '/dist/'
	},
	devServer: {
		static: {
			directory: path.join(__dirname, '.'),
		}
	},
	module: {
		rules: [
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: '/node_modules'
			},
			// {
			// 	test: /\.module\.css$/,
			// 	use: [MiniCssExtractPlugin.loader,
			// 		{
			// 			loader: 'css-loader',
			// 			options: {
			// 				//importLoaders: 0,
			// 				modules: {
			// 					localIdentName: '[local]__[sha1:hash:hex:7]'
			// 				},
			// 			}
			// 		}
			// 	]
			// },
			{
				test: /\.css$/,
				use: [MiniCssExtractPlugin.loader, 'css-loader']
			}
		]
	},
	plugins: [
		new MiniCssExtractPlugin({
			filename: 'main.css'
		})
	]
};


module.exports = (env, options) =>{
	let isProduction = options.mode === 'production';
	//conf.devtool = isProduction ? 'source-map' : 'eval-cheap-module-source-map';
	conf.devtool = isProduction ? false : 'eval-cheap-module-source-map';
	return conf;
}
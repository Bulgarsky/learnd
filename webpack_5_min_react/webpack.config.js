let path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

let conf = {
	entry: './src/main.js',
	output: {
		path: path.resolve(__dirname, './dist'),
		filename: '[name].js',
		publicPath: '/dist/'
	},
	devServer: {
		//overlay: true
		static: {
			directory: path.join(__dirname, '/'),
		}
	},
	module: {
		rules: [
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: '/node_modules'
			},
			{
				test: /\.module\.css$/,
				use: [MiniCssExtractPlugin.loader,
					{
						loader: 'css-loader',
						options: {
							//importLoaders: 0,
							modules: {
								localIdentName: '[local]__[sha1:hash:hex:7]'
							},
						}
					},
					/*
					если есть постцсс - в импортЛоадерс указывается 1
					если оба то 2
					'postcss-loader',
					'sass-loader'
					 */
				]
			},
			{
				test: /^((?!\.module).)*css$/,
				use: [MiniCssExtractPlugin.loader, 'css-loader']
			}
		]
	},
	plugins: [
		new MiniCssExtractPlugin({
			filename: '[name].css'
		})
	],
	optimization: {
		//vue cli 3:
		splitChunks: {
			cacheGroups: {
				//внешние библиотеки
				vendors: {
					name: 'chunk-vendors',
					test: /[\\/]node_modules[\\/]/,
					priority: -10,
					chunks: 'initial'
				},
				//наш код
				common: {
					name: 'chunk-common',
					minChunks: 2,
					priority: -20,
					chunks: 'initial',
					reuseExistingChunk: true
				}
			}
		}
	}
};

module.exports = (env, options) =>{
	let isProduction = options.mode === 'production';
	//скрыть код в продакш:
	//? false
	conf.devtool = isProduction ? 'source-map' : 'eval-cheap-module-source-map';

	//если вебпак-дев-серве ниже 4 версии
	//если продакш смотреть браузер лист из пакаж.жсон, если дев то юзать "веб"
	conf.target = isProduction ? 'browserslist' : 'web';

	return conf;
}
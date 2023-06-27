let path = require('path');

let conf = {
	entry: './src/main.js',
	output: {
		path: path.resolve(__dirname, './dist'),
		filename: 'main.js',
		publicPath: '/dist/'
	},
	devServer: {
		//overlay: true
	},
	module: {
		rules: [
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: '/node_modules'
			}
		]
	}
};

module.exports = (env, options) =>{
	let isProduction = options.mode === 'production'
	conf.devtool = isProduction
		//скрыть код в прод
		? false
		: 'eval-cheap-module-source-map';
	//если вебпак-дев-серве ниже 4 версии
	//если продакш смотреть браузер лист из пакаж.жсон, если дев то юзать "веб"
	conf.target = isProduction ? 'browserslist' : 'web';

	return conf;
}
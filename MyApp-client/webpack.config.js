module.exports = {
  entry: './src/app.js',
  output: {
    path: __dirname + '/src/build/',
    filename: 'bundle.js'
  },
  devtool: 'inline-source-map',
  module: {
    loaders: [
			{
				test: /\.js$/,
				exclude: /node_modules/,
				loader: 'babel-loader',
				query : {
					presets: ['es2015', 'stage-0', 'react']
				}
			},
      {
        test: /\.scss$/,
				loader: 'style!css?modules!sass'
      }
    ]
  },
  resolve: {
    extensions: ['', '.js', '.jsx']
  }
};

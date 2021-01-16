module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],

  devServer: {
    https: true
  },
  publicPath: process.env.NODE.ENV === 'production'
  ? '/killerapp/'
  : '/'
}
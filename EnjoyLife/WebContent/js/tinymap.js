$.fn.tinyMapConfigure({
    // Google Maps API URL
    'api': '//maps.googleapis.com/maps/api/js',
    // Google Maps API Version
    'v': '3.21',
    // GPS Sensor，預設 false
    'sensor': true|false,
    // Google Maps API Key，預設 null
    
    // 使用的地圖語言
    'language': 'zh‐TW'
    // 載入的函式庫名稱，預設 null
    'libraries': 'adsense,drawing,geometry...',
    // 使用個人化的地圖，預設 false
    'signed_in': true|false,
    // MarkerClustererPlus.js 路徑
    // 預設 '//google‐maps‐utility‐library‐v3.googlecode.com/svn/trunk/markerclustererplus/src/markerclusterer_packed.js'
    // 建議下載至自有主機，避免讀取延遲造成無法使用。
    'clusterer': '/path/to/markerclusterer.js'
    // MarkerWithLabel.js 路徑
    // 預設 '//google‐maps‐utility‐library‐v3.googlecode.com/svn/trunk/markerwithlabel/src/markerwithlabel_packed.js'
    // 建議下載至自有主機，避免讀取延遲造成無法使用。
    'withLabel': '/path/to/markerwithlabel.js'
});
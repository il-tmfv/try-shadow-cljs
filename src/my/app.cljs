(ns my.app
  (:require [reagent.core :as r])
  (:require ["material-ui/styles/MuiThemeProvider" :default MuiThemeProvider])
  (:require ["material-ui/styles/getMuiTheme" :default getMuiTheme])
  (:require ["material-ui/RaisedButton" :default RaisedButton])
  )

(def theme (getMuiTheme))

(defn app []
  [:> MuiThemeProvider {:muiTheme theme}
    [:> RaisedButton
     {:on-click #(js/alert "Clicked!") :label "Test button!" :primary true}]]
  )

(r/render [app]
  (.getElementById js/document "app"))

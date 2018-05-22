(ns my.app
  (:require [reagent.core :as r]
            [re-frame.core :as re]
            [my.subs]
            [my.events]
            [my.effects]
            ["material-ui/styles/MuiThemeProvider" :default MuiThemeProvider]
            ["material-ui/styles/getMuiTheme" :default getMuiTheme]
            ["material-ui/RaisedButton" :default RaisedButton]))

(def theme (getMuiTheme))

(defn app []
  (let [click-counter (re/subscribe [:click-counter])]
    [:> MuiThemeProvider {:muiTheme theme}
     [:> RaisedButton
      {:on-click #(re/dispatch [:click-event 7])
       :label @click-counter
       :primary true}]]))

(re/dispatch-sync [:init-db])

(r/render [app]
          (.getElementById js/document "app"))

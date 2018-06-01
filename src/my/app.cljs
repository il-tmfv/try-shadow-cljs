(ns my.app
  (:require [reagent.core :as r]
            [re-frame.core :as re]
            [my.subs]
            [my.events]
            [my.effects]
            [my.about :refer [about-page]]
            [my.welcome :refer [welcome-page]]
            [my.routes :refer [init-accountant!]]
            [my.loading :refer [loading-page]]
            ["material-ui/styles/MuiThemeProvider" :default MuiThemeProvider]
            ["material-ui/styles/getMuiTheme" :default getMuiTheme]
            ["material-ui/RaisedButton" :default RaisedButton]))

(re/dispatch-sync [:init-db])
(init-accountant!)

(def theme (getMuiTheme))

(defn app []
  (let [click-counter (re/subscribe [:click-counter])
        page (re/subscribe [:current-page])]
    [:> MuiThemeProvider {:muiTheme theme}
     [:div
      [:> RaisedButton
       {:on-click #(re/dispatch [:click-event 7])
        :label    @click-counter
        :primary  true}]
      [:div [(case @page
               :welcome welcome-page
               :about about-page
               loading-page)]]]]))

(r/render [app]
          (.getElementById js/document "app"))

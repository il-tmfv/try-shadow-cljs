(ns my.welcome
  (:require
   [accountant.core :as accountant]
   ["material-ui/Paper" :default Paper]))

(defn welcome-page []
  [:> Paper {:style {:padding 16}}
   [:h3 "This is welcome page"]
   [:a {:style {:cursor "pointer"}
        :on-click #(accountant/navigate! "/about")} "go to about page"]])

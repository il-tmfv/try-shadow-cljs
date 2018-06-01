(ns my.about
  (:require
   [accountant.core :as accountant]
   ["material-ui/Paper" :default Paper]))

(defn about-page []
  [:> Paper {:style {:padding 16}}
   [:h3 "This is about page"]
   [:a {:on-click #(accountant/navigate! "/")} "go to welcome page"]])

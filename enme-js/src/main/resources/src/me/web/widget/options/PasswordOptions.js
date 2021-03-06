////////////////////////////////////////////////////////////////////////////////
// /*
//  * Copyright 2015 encuestame
//  *
//  *  Licensed under the Apache License, Version 2.0 (the "License");
//  *  you may not use this file except in compliance with the License.
//  *  You may obtain a copy of the License at
//  *
//  *       http://www.apache.org/licenses/LICENSE-2.0
//  *
//  *  Unless required by applicable law or agreed to in writing, software
//  *  distributed under the License is distributed on an "AS IS" BASIS,
//  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  *  See the License for the specific language governing permissions and
//  *  limitations under the License.
//  *
////////////////////////////////////////////////////////////////////////////////

/**
 * Created by jpicado on 09/06/15.
 */
define( [
	"dojo/_base/declare",
	"dojo/on",
	"dojo/request/script",
	"dijit/_WidgetBase",
	"dijit/_TemplatedMixin",
	"dijit/_WidgetsInTemplateMixin",
	"me/core/main_widgets/EnmeMainLayoutWidget",
	"dijit/Tooltip",
	"me/core/enme",
	"dojo/text!me/web/widget/options/templates/password.html" ],
function(
		declare,
		on,
		script,
		_WidgetBase,
		_TemplatedMixin,
		_WidgetsInTemplateMixin,
		main_widget,
		Tooltip,
		_ENME,
		template ) {
		return declare( [ _WidgetBase, _TemplatedMixin, main_widget, _WidgetsInTemplateMixin ], {

		/**
		 * Template string.
		 * @property
		 */
		templateString: template,

		password: "",

		itemType: "",

		/**
		 *
		 * @method postCreate
		 */
		postCreate: function() {

			//TODO: future, regenerate password
		}

		});
	});

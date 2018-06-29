using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Receive.Data.RNReceiveData
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReceiveDataModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReceiveDataModule"/>.
        /// </summary>
        internal RNReceiveDataModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReceiveData";
            }
        }
    }
}

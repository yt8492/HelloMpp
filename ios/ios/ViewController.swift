//
//  ViewController.swift
//  ios
//
//  Created by megane on 2020/05/11.
//  Copyright © 2020 yt8492. All rights reserved.
//

import UIKit
import common

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let label = UILabel(frame:
            CGRect(x: 0, y: 0, width: view.frame.size.width, height: view.frame.size.height)
        )
        label.textAlignment = .center
        label.font = label.font.withSize(26)
        self.view.addSubview(label)
        let greetMessage = GreetingKt.getGreetingMessage()
        label.text = greetMessage
    }
}
